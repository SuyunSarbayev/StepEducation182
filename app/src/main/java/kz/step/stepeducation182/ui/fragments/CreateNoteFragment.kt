package kz.step.stepeducation182.ui.fragments

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.step.stepeducation182.R

class CreateNoteFragment: Fragment() {

    var noteView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        noteView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_create_note, container, false)
        return noteView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun intiateRequestPhoto(){
        var photoPicker = Intent(Intent.ACTION_CHOOSER)
        startActivity(photoPicker)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        var uri = data?.toUri()
//        BitmapFactory
    }
}