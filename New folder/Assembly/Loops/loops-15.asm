.model small
.data
    buffer dw 100 dup(?)
.code
main proc

              mov  cx, 40
              lea  di, buffer
              mov  ax, 400

    fill_loop:
              mov  [di], ax
              sub  ax, 10
              inc  di
              loop fill_loop

              mov  ax, 4ch
              int  21h
       
main endp

end main