package com.digitalhouse.desafio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.Thumbnail
import com.squareup.picasso.Picasso

class FullscreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fullscreen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thumb = arguments?.getString("thumb")
        val img = view.findViewById<ImageView>(R.id.iv_fullscreen)
        Picasso.get().load(thumb).fit().centerCrop().into(img)
    }

}