/*
object RegistrationUtil {

    var existingUsers = listOf("abc", "xyz")


    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String,
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return false
        }


        if (userName in existingUsers) {
            return false
        }

        fun hasAtLeastTwoCharacters(password: String): Boolean {
            return password.length >= 3
        }

        if (!password.contains(Regex("\\d{2,}"))) {
            return false
        }

        if (password != confirmPassword) {
            return false
        }

        return true
    }
}*/
