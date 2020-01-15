package cc.duduhuo.testa

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.JavaScript
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/15 21:13
 * Description:
 * Remarks:
 * =======================================================
 */
@Route("testa")
@JavaScript("./src/js/test-a.js")
class TestA : VerticalLayout() {
    init {
        val button = Button("Init")
        add(button)
    }
}