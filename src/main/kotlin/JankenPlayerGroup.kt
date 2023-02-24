class JankenPlayerGroup(
    private val players: List<Player>
) {
    fun showHands():List<PlayerHand> {

        val playerHands = mutableListOf<PlayerHand>()
        players.forEach {
            val playerHand = it.showHand()
            playerHands.add(playerHand)
        }
        return playerHands.toList()
    }
}