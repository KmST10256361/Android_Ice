package vcmsa.projects.webapp_one

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //find ui componets



        val edtBILLamt =findViewById<EditText>(R.id.editBILL)


        val edtTipamot =findViewById<EditText>(R.id.edittip)

        val btncal =findViewById<Button>(R.id.calculate)

        val txtbillshow =findViewById<TextView>(R.id.textviewtip)

        val edtpeps = findViewById<EditText>(R.id.editnumpeps)

        btncal.setOnClickListener {

            try {

                val billAmt = edtBILLamt.text.toString().toDouble()

                val tippercent = edtTipamot.text.toString().toDouble()

                val finalPAYtip = billAmt * (tippercent / 100) // cal tip

                //split below



                    val tipspilt = edtpeps.text.toString().toInt()

                    if ( tipspilt ==0 || tipspilt == null   ){

                        txtbillshow.text ="The value for people is invalid "
                    }else   {


                        val PAY=billAmt+finalPAYtip

                        val finalpay=PAY/tipspilt


                        txtbillshow.text = "Tip amount R${String.format("%.2f", finalpay)}"

                    }





            } catch (e: NumberFormatException)
            {

                val billAmt = edtBILLamt.text.toString().toDouble()

                val tippercent = edtTipamot.text.toString().toDouble()

                val finalPAYtip = billAmt * (tippercent / 100) // cal tip

               val onepep = billAmt+finalPAYtip

                txtbillshow.text = "Tip amount R${String.format("%.2f", onepep)}"


            }


        }


    }



    }




