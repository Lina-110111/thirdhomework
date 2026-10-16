package cn.edu.sicnu.cs.hln.thirdhomework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.hln.thirdhomework.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            val intent = Intent()
            // 将输入框内容放入 Intent
            intent.putExtra("name", binding.editTextReturn.text.toString())
            // setResult 将数据传回给上一个 Activity（MainActivity）
            setResult(RESULT_OK, intent)
            // 销毁当前 Activity，回到 MainActivity
            finish()
        }
    }
}