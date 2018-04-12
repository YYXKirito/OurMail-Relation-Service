package com.ourmail.relationservice.domain

import javax.persistence.*

class LabelShip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0L
    var userId=0L
    var groupId=0L
    var labelId=0L
}