package ro.cunbm.myktlapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG ="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // not here (outside of coroutine): doNetworkCall()
        GlobalScope.launch{
            delay(1000L)
            Log.d(TAG, "Coroutine says Hello from thread ${Thread.currentThread().name}")
            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer)
            Log.d(TAG, networkCallAnswer2)
        }
        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")
        Thread.sleep(2000L);
    }

    suspend fun doNetworkCall():String{
        delay(3000L)
        return "\n*** This is the message 1\n"
    }

    suspend fun doNetworkCall2():String{
        delay(3000L)
        return "\n*** This is the message 2\n"
    }
}