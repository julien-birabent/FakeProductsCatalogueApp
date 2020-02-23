package com.julienbirabent.fakeproductscatalogue.data.source.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.entity.UniqueModel
import com.julienbirabent.fakeproductscatalogue.rx.firebase.RxFireStore
import io.reactivex.Observable
import io.reactivex.Single


fun <T : Model> FireStoreDataSource.addNewDocument(
    collectionPath: String,
    data: T
): Single<T> {
    return RxFireStore.addDocument(database, collectionPath, data)
        .map { data }
}

fun <T : UniqueModel> FireStoreDataSource.setDocument(
    collectionPath: String,
    data: T
): Single<T> {
    return RxFireStore.setDocument(database, collectionPath, data)
}

fun <T : Model> FireStoreDataSource.setDocument(
    collectionPath: String,
    documentId: String,
    data: T
): Single<T> {
    return RxFireStore.setDocument(database, collectionPath, documentId, data)
}

fun <T : Model> FireStoreDataSource.deleteDocumentExt(
    collectionPath: String,
    documentPath: String,
    documentToDelete: T
): Single<T> {
    return RxFireStore.deleteDocument(database, collectionPath, documentPath, documentToDelete)
}

fun <T : Model> FireStoreDataSource.getFireStoreCollection(
    collectionPath: String,
    modelClass: Class<T>,
    queryBlock: (CollectionReference.() -> Unit) = {}
): Observable<List<T>> {
    return RxFireStore.observeCollection(database, collectionPath, queryBlock)
        .map { it.documents }
        .map { it.mapNotNull { snapshot -> snapshot.toObject(modelClass) } }
}

fun <T : Model> FireStoreDataSource.getFireStoreDocument(
    collectionPath: String,
    path: String,
    modelClass: Class<T>,
    queryBlock: (DocumentReference.() -> Unit) = {}
): Observable<T> {
    return RxFireStore.observeDocument(database, collectionPath, path, queryBlock)
        .map { it.toObject(modelClass) }
}
