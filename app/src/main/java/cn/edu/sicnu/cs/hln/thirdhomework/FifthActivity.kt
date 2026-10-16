package cn.edu.sicnu.cs.hln.thirdhomework

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.hln.thirdhomework.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 恢复状态：如果 savedInstance 不为空，说明经历了横竖屏切换
        if (savedInstanceState != null) {
            val baseTime = savedInstanceState.getLong("base_time")
            isRunning = savedInstanceState.getBoolean("is_running")

            binding.chronometer.base = baseTime
            if (isRunning) {
                binding.chronometer.start() // 恢复正在运行的状态
            } else {
                binding.chronometer.stop()
            }
        }

        binding.btnStart.setOnClickListener {
            // 设置基准时间
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.start()
            isRunning = true
        }

        binding.btnPause.setOnClickListener {
            binding.chronometer.stop()
            isRunning = false
        }

        binding.btnReset.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() // 重置基准时间
            binding.chronometer.stop()
            isRunning = false
        }
    }

    // 保存状态：在 Activity 被销毁（例如横竖屏切换）之前调用
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("base_time", binding.chronometer.base)
        outState.putBoolean("is_running", isRunning)
    }
}