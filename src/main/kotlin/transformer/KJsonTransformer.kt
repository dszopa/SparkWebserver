package transformer

import com.google.gson.Gson

private val gson = Gson()
fun toJson(model: Any): String {
    return gson.toJson(model)
}

