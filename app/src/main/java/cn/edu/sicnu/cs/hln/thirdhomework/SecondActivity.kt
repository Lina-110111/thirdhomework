package cn.edu.sicnu.cs.hln.thirdhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.hln.thirdhomework.databinding.ActivitySecondBinding // 注意这里是 ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 绑定布局
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 获取 MainActivity 传过来的数据
        val name = intent.getStringExtra("name")
        // 显示在 TextView 上（用 string 资源格式化，符合作业规范）
        binding.tvReceived.text = getString(R.string.received_name, name)
    }
}