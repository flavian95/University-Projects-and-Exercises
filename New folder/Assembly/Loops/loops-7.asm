.model small
.data
    buffer         db 20 dup(?)
    memoryLocation dw 20h
.code
main proc
              mov  cx, 20
              lea  di, buffer
              mov  al, 5h

    fill_loop:
              mov  [di], al
              inc  di
              inc  al
              loop fill_loop

              mov  cx, 20
              lea  di, buffer
              mov  ax, 0

    sum_loop: 
              add  ax, [di]
              inc  di
              loop sum_loop

              mov  [memoryLocation], ax

              mov  ah, 4Ch
              int  21h
main endp

end main
