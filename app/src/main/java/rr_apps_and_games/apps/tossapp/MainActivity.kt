package rr_apps_and_games.apps.tossapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onCoinTap()
    }

    private fun onCoinTap() {

        coin.setOnClickListener{

            val randomNumber = (1..2).random()

            if(randomNumber == 1){
                flipTheCoin(R.drawable.heads_cutout,"IT IS HEADS!!")
            }
            else{
                flipTheCoin(R.drawable.tails_cutout,"IT IS TAILS!!")
            }
        }
    }

    private fun flipTheCoin(imageId: Int, coinSide: String){

        coin.animate().apply {
            duration = 1000
            rotationYBy(1800f)
            coin.isClickable = false
        }.withEndAction {

            coin.setImageResource(imageId)
            Toast.makeText(this,coinSide,Toast.LENGTH_SHORT).show()
            coin.isClickable = true
        }.start()
    }
}