
cmake_minimum_required(VERSION 3.4.1) # CMake版本

add_library(
             test-lib # 动态库的名称

             SHARED # 作为共享库（动态引入）

             src/main/cpp/test-lib.cpp # cpp源文件路径
            )

find_library(
                log-lib
                log
            )

# 被链接的目标库的名称
target_link_libraries(
                       test-lib
                       ${log-lib}
                     )
