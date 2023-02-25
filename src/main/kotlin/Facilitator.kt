class Facilitator(
    private val players: List<Player>,
    private val judgement: Judgement,
    private val ranking: Ranking
) {
    fun startJanken() {
        println("じゃんけんによる順位決めを開始します")
        val jankenPlayerGroup = JankenPlayerGroup(players)
        match(jankenPlayerGroup)

        println("じゃんけんによる順位決めが終了しました")
        // 順位表示
        ranking.displayRank(players)
    }

    private fun match(jankenPlayerGroup: JankenPlayerGroup) {
        println("じゃんけんポン!")
        // じゃんけんの手を出す
        val playerHands = jankenPlayerGroup.showHands()
        println(playerHands.getPlayerHands())

        // 勝敗確認
        var result = judgement.judge(playerHands)

        // もし引き分けなら、再度じゃんけんする
        while (result.isDraw()) {
            println("引き分け")
            // じゃんけんの手を出す
            println("じゃんけんポン!")
            val playerNextHands = jankenPlayerGroup.showHands()
            println(playerNextHands.getPlayerHands())

            // 勝敗確認
            result = judgement.judge(playerNextHands)
        }

        // 勝敗ごとでグループを分ける
        val winnerGroup = result.filterWinners()
        println("勝ち: ${winnerGroup.getPlayerNames()}")

        val loserGroup = result.filterLosers()
        println("負け: ${loserGroup.getPlayerNames()}")

        // 2人以上のグループでプレイ続行
        if (winnerGroup.size() > 1) {
            match(winnerGroup.createJankenPlayerGroup())
        }

        if (loserGroup.size() > 1) {
            match(loserGroup.createJankenPlayerGroup())
        }
    }
}