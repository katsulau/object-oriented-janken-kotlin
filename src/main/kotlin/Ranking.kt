import java.lang.StringBuilder

class Ranking {

    fun rank(players: List<Player>) {
        val showPlayResults = listOf<String>()
        val showPlayResultMap = mapOf<String, Player>()

        players.forEach {
            showPlayResults.plus(it.showPlayResult())
            showPlayResultMap.plus(Pair(it.showPlayResult(), it))
        }


        showPlayResults.sorted()
        val result = StringBuilder()

        var count = 1
        showPlayResults.forEach {
            val player = showPlayResultMap[it] ?: throw IllegalArgumentException("存在しないキーで取得処理がされています。 key: ${it}")
            result.append("${count}位: ${player.name}\n")
            count++
        }

        println(result.toString())
    }
}