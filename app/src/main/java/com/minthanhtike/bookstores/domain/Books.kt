package com.minthanhtike.bookstores.domain

data class BooksListModel(
    val bookContainerModel: List<BookContainerModel>
)

abstract class BookContainerModel

data class RecommendBookContainerList(
    val title: String,
    val recommendedBookList:List<RecommendBookModel>
):BookContainerModel()

data class BestSellerBookListContainer(
    val title: String,
    val bestSellerBookList:List<BestSellerBookModel>
):BookContainerModel()

data class NewArrivalBookListContainer(
    val title: String,
    val newArrivalBookList:List<NewArrivalsBookModel>
):BookContainerModel()

data class NormalBookContainerList(
    val title: String,
    val normalBookList:List<NormalBooksModel>
):BookContainerModel()

data class CategoryContainerModel(
    val id: String,
    val name: String
)

data class CategoryContainer(
    val categoryList:List<CategoryContainerModel>
):BookContainerModel()


abstract class BookTypeModel
data class RecommendBookModel(
    val id: String,
    val name: String,
    val description: String,
    val bookCover: String,
    val author: AuthorModel,
    val category: CategoryModel,
    val rating: Double,
    val price: Double,
) : BookTypeModel()
data class BestSellerBookModel(
    val id: String,
    val name: String,
    val description: String,
    val bookCover: String,
    val author: AuthorModel,
    val category: CategoryModel,
    val rating: Double,
    val price: Double,
) : BookTypeModel()

data class NewArrivalsBookModel(
    val id: String,
    val name: String,
    val description: String,
    val bookCover: String,
    val author: AuthorModel,
    val category: CategoryModel,
    val rating: Double,
    val price: Double,
) : BookTypeModel()

data class NormalBooksModel(
    val id: String,
    val name: String,
    val description: String,
    val bookCover: String,
    val author: AuthorModel,
    val category: CategoryModel,
    val rating: Double,
    val price: Double
):BookTypeModel()

data class AuthorModel(
    val description:String,
    val id: String,
    val name: String
)
data class CategoryModel(
    val categoryName: String,
    val id: String
)