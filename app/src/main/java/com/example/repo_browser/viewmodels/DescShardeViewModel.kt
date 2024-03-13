import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DescSharedViewModel constructor() : ViewModel() {
    private val _DescText = MutableLiveData<String>()
    val DescText: LiveData<String> = _DescText

    fun UpdateDescText(newText: String) {
        _DescText.value = newText
    }
}
