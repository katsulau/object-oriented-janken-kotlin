import org.junit.jupiter.api.Test

class RankingTest {

    @Test
    fun displayRank_positive() {
        val player1 = Player("dummy1")
        val player2 = Player("dummy2")
        val player3 = Player("dummy3")
        val player4 = Player("dummy4")
        val player5 = Player("dummy5")


        player3.recordResult(MatchResultType.DRAW)
        player3.recordResult(MatchResultType.WIN)

        player4.recordResult(MatchResultType.DRAW)
        player4.recordResult(MatchResultType.LOSE)
        player4.recordResult(MatchResultType.WIN)
        player4.recordResult(MatchResultType.DRAW)
        player4.recordResult(MatchResultType.WIN)

        player2.recordResult(MatchResultType.DRAW)
        player2.recordResult(MatchResultType.LOSE)
        player2.recordResult(MatchResultType.WIN)
        player2.recordResult(MatchResultType.DRAW)
        player2.recordResult(MatchResultType.LOSE)


        player5.recordResult(MatchResultType.DRAW)
        player5.recordResult(MatchResultType.LOSE)
        player5.recordResult(MatchResultType.LOSE)
        player5.recordResult(MatchResultType.WIN)


        player1.recordResult(MatchResultType.DRAW)
        player1.recordResult(MatchResultType.LOSE)
        player1.recordResult(MatchResultType.LOSE)
        player1.recordResult(MatchResultType.LOSE)


        val ranking = Ranking()
        ranking.displayRank(listOf(player1, player2, player3, player4, player5))
    }
}