class Facilitator(
    private val players: List<Player>,
    private val judgement: Judgement,
    private val ranking: Ranking
) {
    fun startJanken() {
        // じゃんけんを開始する

        val jankenPlayerGroup = JankenPlayerGroup(players)

        // じゃんけんの手を出す
        val playerHands = jankenPlayerGroup.showHands()

        // 勝敗確認
        val result = judgement.judge(playerHands)

        // もし引き分けなら、再度じゃんけんする

        // 勝敗が決まっていれば、勝敗ごとでグループを分ける

        // 勝敗によりグループ分けで1人になった場合はゲームから抜ける

        // 2人以上のグループでプレイ続行

        // プレイするグループがなくなったら、ゲーム終了。

        // 順位表示
        ranking.rank(players)
    }
}