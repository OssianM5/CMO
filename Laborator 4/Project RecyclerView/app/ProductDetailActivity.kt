class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val imageView: ImageView = findViewById(R.id.productImageDetail)
        val nameTextView: TextView = findViewById(R.id.productNameDetail)
        val detailsTextView: TextView = findViewById(R.id.productDetailsDetail)

        val name = intent.getStringExtra("name")
        val details = intent.getStringExtra("details")
        val imageResId = intent.getIntExtra("imageResId", 0)

        nameTextView.text = name
        detailsTextView.text = details
        imageView.setImageResource(imageResId)
    }
}
