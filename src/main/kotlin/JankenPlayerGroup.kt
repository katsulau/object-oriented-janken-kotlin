class JankenPlayerGroup(
    private val players: List<Player>
) {
    fun showHands(): PlayerHands {

        val playerHands = mutableListOf<PlayerHand>()
        players.forEach {
            val playerHand = it.showHand()
            playerHands.add(playerHand)
        }
        return PlayerHands(playerHands.toList())
    }
}