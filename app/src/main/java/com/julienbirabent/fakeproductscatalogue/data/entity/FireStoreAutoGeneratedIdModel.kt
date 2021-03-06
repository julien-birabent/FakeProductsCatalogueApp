package com.julienbirabent.fakeproductscatalogue.data.entity

import com.google.firebase.firestore.DocumentId

abstract class FireStoreAutoGeneratedIdModel : UniqueModel {
    @DocumentId
    override var uid: String = ""
}