package com.digitalhouse.desafio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhe.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.home_toolbar

class DetalheFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_detalhe, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detail_toolbar.setNavigationOnClickListener{
            findNavController().popBackStack()
        }

        val results = arguments?.get("hq") as Results
        val title = view.findViewById<TextView>(R.id.tv_title)
        title.text = results.title

        val thumb = view.findViewById<ImageView>(R.id.iv_thumbnail_detalhe)
        val thumbURL = "${results.thumbnail.path}.${results.thumbnail.extension}"
        Picasso.get().load(thumbURL).fit().centerCrop().into(thumb)

        val desc = view.findViewById<TextView>(R.id.tv_descrip)
        desc.text = results.description

        val date = view.findViewById<TextView>(R.id.tv_published)
        date.text = "Published: " + results.dates[0].date.substring(0, 10)

        val price = view.findViewById<TextView>(R.id.tv_price)
        price.text = "Price: " + results.prices[0].price.toString()

        val pages = view.findViewById<TextView>(R.id.tv_pages)
        pages.text = "Pages: " + results.pageCount

        iv_character.setOnClickListener{
            val bundle = bundleOf("thumb" to thumbURL)
            findNavController().navigate(R.id.action_detalheFragment_to_fullscreenFragment, bundle)
        }
    }
}