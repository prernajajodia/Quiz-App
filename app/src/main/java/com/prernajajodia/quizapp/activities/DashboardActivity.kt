package com.prernajajodia.quizapp.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.prernajajodia.quizapp.R
import com.prernajajodia.quizapp.activities.adapters.QuizAdapter
import com.prernajajodia.quizapp.activities.models.Quiz
import com.prernajajodia.quizapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var adapter: QuizAdapter
    lateinit var binding: ActivityDashboardBinding
    lateinit var firebaseAuth: FirebaseAuth

    lateinit var firebaseFirestore: FirebaseFirestore

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private var quizList = mutableListOf<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        setUpFireStore()
        setUpDrawerLayout()
        populateDummyData()
        setUpRecyclerView()

    }

    private fun setUpFireStore() {

        firebaseFirestore = FirebaseFirestore.getInstance()
        val collectionReference = firebaseFirestore.collection("quizzes")
        collectionReference.addSnapshotListener { value, error ->
            if (value == null || error!= null){
                Toast.makeText(this, "Data fetching error", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quiz::class.java).toString())
        }
    }

    private fun populateDummyData() {
        quizList.add(Quiz(id = "Sunday", title = "hello world"))
        quizList.add(Quiz(id = "Sunday", title = "hello world"))
        quizList.add(Quiz(id = "Sunday", title = "hello world"))
        quizList.add(Quiz(id = "Sunday", title = "hello world"))
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList)
        binding.quizRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.quizRecyclerView.adapter = adapter
    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(binding.topAppBar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawer, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}