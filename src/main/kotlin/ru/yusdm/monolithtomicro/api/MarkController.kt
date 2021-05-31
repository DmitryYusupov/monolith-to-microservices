package ru.yusdm.monolithtomicro.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.monolithtomicro.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.dto.MarkDTO
import ru.yusdm.monolithtomicro.service.http.MarkHttpService

@RestController
@RequestMapping("/api/mark")
class MarkController(private val markHttpService: MarkHttpService) {

    @PostMapping
    fun saveMark(createMarkCommand: CreateMarkCommandDTO): MarkDTO {
        return markHttpService.save(createMarkCommand)
    }

}