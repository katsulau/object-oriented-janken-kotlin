fun main() {
    val yamada = Player("山田")
    val saito = Player("斉藤")
    val tanaka = Player("田中")
    val takahashi = Player("高橋")
    val suzuki = Player("鈴木")

    val facilitator = Facilitator(
        judgement = Judgement(),
        players = listOf(yamada, saito, tanaka, takahashi, suzuki),
        ranking =  Ranking()
    )

    facilitator.startJanken()
}