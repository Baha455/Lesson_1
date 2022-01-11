import com.google.gson.annotations.SerializedName

data class TriviaCategoriesResponse(
	@SerializedName("trivia_categories") val triviaCategories: List<TriviaCategories>
)

data class TriviaCategories (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String
)