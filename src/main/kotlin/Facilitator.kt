class Facilitator(
    private val players: List<Player>,
    private val judgement: Judgement,
    private val ranking: Ranking
) {
    fun startJanken() {

        val jankenPlayerGroup = JankenPlayerGroup(players)
        match(jankenPlayerGroup)

        // 順位表示
        ranking.rank(players)
    }

    private fun match(jankenPlayerGroup: JankenPlayerGroup) {
        println("じゃんけんポン!")
        // じゃんけんの手を出す
        val playerHands = jankenPlayerGroup.showHands()
        // 勝敗確認
        var result = judgement.judge(playerHands)
        var matchResultType = result.first().value.second

        // もし引き分けなら、再度じゃんけんする
        while (matchResultType == MatchResultType.DRAW) {
            // じゃんけんの手を出す
            val playerHands = jankenPlayerGroup.showHands()

            // 勝敗確認
            result = judgement.judge(playerHands)
            matchResultType = result.first().value.second
        }

        // 勝敗ごとでグループを分ける
        val winnerGroup = result.filter { it.value.second == MatchResultType.WIN }.toList()
        val loserGroup = result.filter { it.value.second == MatchResultType.LOSE }.toList()

        val isNotOneWinner = winnerGroup.size != 1
        val isNotOneLoser = loserGroup.size != 1

        // 2人以上のグループでプレイ続行
        if (isNotOneWinner) {
            val winners = winnerGroup.map { it.value.first }.toList()
            val winnerPlayerGroup = JankenPlayerGroup(winners)
            match(winnerPlayerGroup)
        }

        if (isNotOneLoser) {
            val losers = loserGroup.map { it.value.first }.toList()
            val loserPlayerGroup = JankenPlayerGroup(losers)
            match(loserPlayerGroup)
        }
    }
}