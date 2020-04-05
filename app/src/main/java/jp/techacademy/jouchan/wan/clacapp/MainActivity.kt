package jp.techacademy.jouchan.wan.clacapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)

        if(editText1.text.toString().equals("") || editText2.text.toString().equals("")){
            val snackbar = Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
            snackbar.show()
            return
        }

        val value1 = editText1.text.toString().toDouble()
        val value2 = editText2.text.toString().toDouble()

        when(v.id){
            R.id.button1->{
                val sum = value1 + value2
                intent.putExtra("sum",sum)
                startActivity(intent)
            }
            R.id.button2->{
                val sum = value1 - value2
                intent.putExtra("sum",sum)
                startActivity(intent)
            }
            R.id.button3->{
                val sum = value1 * value2
                intent.putExtra("sum",sum)
                startActivity(intent)
            }
            R.id.button4->{
                val sum = value1 / value2
                intent.putExtra("sum",sum)
                startActivity(intent)
            }
        }
    }
}

