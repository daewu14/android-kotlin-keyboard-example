package id.daewu.keyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import id.daewu.keyboardtest.R
import id.daewu.keyboardtest.databinding.MainKeyboardBinding

class KiriminAjaInputMethodService: InputMethodService() {

    lateinit var rootView : View
    private lateinit var binding: MainKeyboardBinding

    override fun onCreateInputView(): View {
        rootView = layoutInflater.inflate(R.layout.main_keyboard, null)
        return rootView
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        binding = MainKeyboardBinding.inflate(LayoutInflater.from(this))
        setInputView(binding.root)
        val keyboard = Keyboard(this, R.xml.qwerty)
        binding.keyboard.keyboard = keyboard
    }

}