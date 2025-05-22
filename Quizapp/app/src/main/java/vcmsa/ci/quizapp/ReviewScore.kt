package vcmsa.ci.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView
import android.widget.Button

class ReviewScore : AppCompatActivity() {

    var scoretext: TextView? = null
    var review: TextView? = null
    var marks: Button? = null
    var exit: Button? = null
    var score = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_score)

        scoretext = findViewById<View>(R.id.scoretext) as TextView
        review = findViewById<View>(R.id.reviewout) as TextView
        marks = findViewById<View>(R.id.reviewbttn) as Button
        exit = findViewById<View>(R.id.exitbttn) as Button
        score = intent.getIntExtra("score",0)

        //Score will be displayed here
        scoretext!!.text = "Your final score from the whole quiz concludes to... /5:$score "

        marks!!.setOnClickListener{


            review!!.text =
                ("Cape Town is the Second captial city of South Africa -\n True \n " +
                        "Where was the tv show 'Frineds' based in?- \n New York City \n"+
                        "You have to login into your android studio to use your virtual machine. -\n False \n "+
                        "Cyril Ramaphosa owns half McDonalds in South Africa. -\n True \n"+
                        "Apple is the largest company with the largest net worth. -\n False \n")

            val intent = Intent(this,exercisepage::class.java)
            intent.getStringExtra("Score")
            startActivity(intent)
            finish()


        }
        exit!!.setOnClickListener{
            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}