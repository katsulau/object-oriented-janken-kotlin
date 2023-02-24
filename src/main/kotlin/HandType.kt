enum class HandType {
    PAPER,
    ROCK,
    SCISSORS;

    companion object {
        /**
         * グーチョキパーのいずれかをランダムに返す
         */
        fun getRandom(): HandType {
            return HandType.values().random()
        }
    }
}