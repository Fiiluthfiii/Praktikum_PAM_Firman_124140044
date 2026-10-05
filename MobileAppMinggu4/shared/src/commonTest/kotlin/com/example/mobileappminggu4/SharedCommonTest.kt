package com.example.mobileappminggu4

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import com.example.mobileappminggu4.viewmodel.ProfileViewModel

class SharedCommonTest {

    @Test
    fun saveProfileTrimsAndUpdatesProfile() {
        val viewModel = ProfileViewModel()
        viewModel.startEditing()
        viewModel.updateDraftName("  Ayu  ")
        viewModel.updateDraftBio("  Mahasiswa  ")

        viewModel.saveProfile()

        assertEquals("Ayu", viewModel.uiState.value.name)
        assertEquals("Mahasiswa", viewModel.uiState.value.bio)
        assertFalse(viewModel.uiState.value.isEditing)
    }

    @Test
    fun cancelEditingRestoresSavedProfile() {
        val viewModel = ProfileViewModel()
        val savedName = viewModel.uiState.value.name
        val savedBio = viewModel.uiState.value.bio
        viewModel.startEditing()
        viewModel.updateDraftName("Nama sementara")
        viewModel.updateDraftBio("Bio sementara")

        viewModel.cancelEditing()

        assertEquals(savedName, viewModel.uiState.value.draftName)
        assertEquals(savedBio, viewModel.uiState.value.draftBio)
        assertFalse(viewModel.uiState.value.isEditing)
    }

    @Test
    fun darkModeCanBeToggled() {
        val viewModel = ProfileViewModel()

        viewModel.setDarkMode(true)
        assertTrue(viewModel.uiState.value.isDarkMode)

        viewModel.setDarkMode(false)
        assertFalse(viewModel.uiState.value.isDarkMode)
    }
}