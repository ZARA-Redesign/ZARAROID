package snp.zararoid.network.response

import android.text.TextUtils
import android.util.Log
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <ResponseType> Call<ResponseType>.customEnqueue(
    onSuccess: ((ResponseType) -> Unit)? = null,
    onError:((errorMessage:String)->Unit)? = null,
    onFail:((Throwable)->Unit)? = null
    ) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.takeIf { it.isSuccessful }
                ?.body()
                ?.let { it -> onSuccess?.invoke(it) }
                ?: onErrorEvent(response.errorBody()?.string())
        }

        private fun onErrorEvent(errorBody: String?) {
            val errorMessage = errorBody?.let { JSONObject(it) }
                ?.getString("message")
                ?: return
            onError?.invoke(errorMessage)
        }

        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            printFailureMessage(t)
            onFail?.invoke(t)
        }

        private fun printFailureMessage(t: Throwable) {
            val errorTag = "SERVER_ERROR_MESSAGE"
            Log.d(errorTag, "${t.message}\n")
            Log.d(errorTag,"${t.localizedMessage} \n")
            Log.d(errorTag,TextUtils.join("\n", t.stackTrace))
        }

    })
}