package com.example.mobileappminggu4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappminggu4.data.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun startEditing() {
        _uiState.update { state ->
            state.copy(isEditing = true, draftName = state.name, draftBio = state.bio)
        }
    }

    fun updateDraftName(name: String) {
        _uiState.update { it.copy(draftName = name) }
    }

    fun updateDraftBio(bio: String) {
        _uiState.update { it.copy(draftBio = bio) }
    }

    fun saveProfile() {
        _uiState.update { state ->
            if (state.draftName.isBlank()) state
            else state.copy(name = state.draftName.trim(), bio = state.draftBio.trim(), isEditing = false)
        }
    }

    fun cancelEditing() {
        _uiState.update { state ->
            state.copy(isEditing = false, draftName = state.name, draftBio = state.bio)
        }
    }

    fun setDarkMode(enabled: Boolean) {
        _uiState.update { it.copy(isDarkMode = enabled) }
    }
}