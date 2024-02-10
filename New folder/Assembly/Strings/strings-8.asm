.model small
.data
    S1   db 'abcd$'
    S2   db 'efg$'
    D    db 255 dup(?)

.code
main proc
                       lea si, S1
                       lea di, D

    copy_S1:           
                       mov al, [si]
                       cmp al, '$'
                       je  end_copy_S1
                       mov [di], al
                       inc si
                       inc di
                       jmp copy_S1

    end_copy_S1:       

                       lea si, S2
                       mov cx, 0

    find_length_S2:    
                       cmp byte ptr [si], '$'
                       je  end_find_length_S2
                       inc cx
                       inc si
                       jmp find_length_S2

    end_find_length_S2:

                       lea di, D
                       add di, cx

    copy_S2:           
                       dec si
                       mov al, [si]
                       cmp al, '$'
                       je  end_copy_S2
                       mov [di], al
                       dec di
                       jmp copy_S2

    end_copy_S2:       

                       mov byte ptr [di], '$'


                       mov ah, 4Ch
                       int 21h
main endp

end main
