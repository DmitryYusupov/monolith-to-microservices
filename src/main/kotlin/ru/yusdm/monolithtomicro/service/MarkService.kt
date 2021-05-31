package ru.yusdm.monolithtomicro.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.monolithtomicro.domain.Mark
import ru.yusdm.monolithtomicro.domain.toEntity
import ru.yusdm.monolithtomicro.repository.MarkRepository
import ru.yusdm.monolithtomicro.repository.ModelRepository

@Service
@Transactional
class MarkService(
    private val markRepository: MarkRepository,
    private val modelRepository: ModelRepository
) {

    fun createMark(createMarkCommand: CreateMarkCommand): Mark {

        return with(createMarkCommand) {
            val mark = Mark(name = this.name)
            markRepository.save(mark.toEntity())

            mark
        }
    }

    fun addModelToMark() {
        //your logic here
    }

}

