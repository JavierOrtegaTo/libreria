package com.example.mylibreria

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button

class Component {

    lateinit var dialog: Dialog

    fun getMensajeAlertaReserva(
        context: Context,
        onClickListener : () -> Unit
    ): Dialog {
        dialog = Dialog(context, R.style.wideDialog)

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewDialog = inflater.inflate(R.layout.modal_custom, null)

        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(viewDialog)
        dialog.setCancelable(false)

        val btnCancelar: Button = viewDialog.findViewById(R.id.btnCancelar)
        val btnVerMisReservas: Button = viewDialog.findViewById(R.id.btnVerMisReservas)


        btnCancelar.let {
            it.setOnClickListener {
                dialog.dismiss()
            }
        }

        btnVerMisReservas.let {
            it.setOnClickListener {
                dialog.dismiss()
                onClickListener.invoke()
            }
        }
        return dialog
    }

}