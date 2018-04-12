package com.ourmail.relationservice.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0L
    var labelName=""
}