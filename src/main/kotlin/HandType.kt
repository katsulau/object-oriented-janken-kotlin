enum class HandType(
    val japaneseName: String
) {
    PAPER("パー"),
    ROCK("グー"),
    SCISSORS("チョキ");

    companion object {
        /**
         * グーチョキパーのいずれかをランダムに返す
         */
        fun getRandom(): HandType {
            return HandType.values().random()
        }
    }
}