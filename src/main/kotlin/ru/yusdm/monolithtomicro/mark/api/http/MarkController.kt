package ru.yusdm.monolithtomicro.mark.api.http

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.yusdm.monolithtomicro.mark.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.mark.dto.MarkDTO

@RestController
@RequestMapping("/api/mark")
class MarkController(private val markHttpService: MarkHttpService) {

    @PostMapping
    fun saveMark(@RequestBody createMarkCommand: CreateMarkCommandDTO): ResponseEntity<MarkDTO> {
        return markHttpService.save(createMarkCommand)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<MarkDTO>> {
        return markHttpService.finaAll()
    }

}