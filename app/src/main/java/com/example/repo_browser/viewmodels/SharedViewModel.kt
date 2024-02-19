import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel constructor() : ViewModel() {
    private val _sharedText = MutableLiveData<String>()
    val sharedText: LiveData<String> = _sharedText

    fun updateText(newText: String) {
        _sharedText.value = newText
    }
}
