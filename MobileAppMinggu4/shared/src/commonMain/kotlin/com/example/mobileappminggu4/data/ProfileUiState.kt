package com.example.mobileappminggu4.data

data class ProfileUiState(
    val name: String = "Firman Luthfiansyah",
    val nim: String = "124140044",
    val bio: String = "Mahasiswa Informatika yang tertarik pada pengembangan aplikasi mobile dan web.",
    val email: String = "firmanluthfidev@gmail.com",
    val phone: String = "+62 812-3456-7890",
    val location: String = "Lampung, Indonesia",
    val isEditing: Boolean = false,
    val isDarkMode: Boolean = false,
    val draftName: String = name,
    val draftBio: String = bio,
)