package com.example.postgresqlinsertion.logic.repository

import com.example.postgresqlinsertion.logic.entity.ActiveTransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ActiveTransactionRepository: JpaRepository<ActiveTransactionEntity, UUID>