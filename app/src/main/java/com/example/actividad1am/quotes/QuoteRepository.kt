package com.example.actividad1am.quotes

class QuoteRepository {

    private val service = QuoteRetrofitHelper.getRetrofitService()

    suspend fun getRandomQuote(): String {
        return try {
            val response = service.getRandomQuote()
            val quote = response.body()?.firstOrNull()

            if (response.isSuccessful && quote != null && quote.q.isNotBlank()) {
                val author = quote.a.ifBlank { "Autor desconocido" }
                "\"${quote.q}\" - $author"
            } else {
                FALLBACK_QUOTE
            }
        } catch (e: Exception) {
            FALLBACK_QUOTE
        }
    }

    companion object {
        const val FALLBACK_QUOTE = "\"Hoy es un buen dia para avanzar un poco mas.\" - StreakUP"
    }
}
