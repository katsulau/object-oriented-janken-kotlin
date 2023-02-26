import java.lang.StringBuilder

class Ranking {

    fun displayRank(players: List<Player>) {
        val showPlayResults = mutableListOf<String>()
        val showPlayResultMap = mutableMapOf<String, Player>()

        players.forEach {
            showPlayResults.add(it.showPlayResult())
            showPlayResultMap[it.showPlayResult()] = it
        }


        val sortedResults = showPlayResults.sorted()
        val result = StringBuilder()

        var count = 1
        sortedResults.forEach {
            val player = showPlayResultMap[it] ?: throw IllegalArgumentException("存在しないキーで取得処理がされています。 key: ${it}")
            result.append("${count}位: ${player.name}\n")
            count++
        }

        println(result.toString())
    }
}