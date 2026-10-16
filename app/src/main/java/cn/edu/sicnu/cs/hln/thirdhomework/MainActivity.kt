package cn.edu.sicnu.cs.hln.thirdhomework

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.hln.thirdhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. 声明 ViewBinding 变量
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 2. 初始化 Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 按钮1：正向传参给 SecondActivity
        binding.button1.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name) // 键值对传递
            startActivity(intent)
        }

        // 按钮2：跳转 ThirdActivity 并等待返回结果 (requestCode = 1)
        binding.button2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // 废弃方法，但为了契合老师代码，这里保留
            startActivityForResult(intent, 1)
        }

        // 按钮3：跳转 FourthActivity（相机）
        binding.button3.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }

        // 按钮4：跳转 FifthActivity（秒表）
        binding.button4.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }
    }

    // 3. 接收 ThirdActivity 返回的数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val returnedName = data?.getStringExtra("name")
            binding.editTextText.setText(returnedName)
            Toast.makeText(this, "返回成功", Toast.LENGTH_SHORT).show()
        }
    }
}