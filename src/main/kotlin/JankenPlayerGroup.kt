class JankenPlayerGroup(
    private val players: List<Player>
) {
    fun showHands():List<PlayerHand> {

        val playerHands = listOf<PlayerHand>()
        players.forEach {
            val playerHand = it.showHand()
            playerHands.plus(playerHand)
        }

        return playerHands
    }
}